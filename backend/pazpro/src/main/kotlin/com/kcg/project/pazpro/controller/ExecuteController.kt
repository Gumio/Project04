package com.kcg.project.pazpro.controller

import com.kcg.project.pazpro.service.ExecuteServiceFacade
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/execute")
class ExecuteController(
    val executeServiceFacade: ExecuteServiceFacade
) {
    @CrossOrigin
    @PostMapping("")
    fun execute(@RequestParam("code_text") plainCodeText: String, @RequestParam("id", required = true) id: Int): ExecuteResponse =
//        val code = "for i in 1..30;if i%15==0;puts "FizzBuzz!";elsif i%3==0;puts "Fizz!";elsif i%5==0;puts "Buzz!";else;puts i;end;end;"
        executeServiceFacade.execute(plainCodeText, id)

    data class ExecuteResponse(
        val result: Boolean,
        val example: Boolean,
        val stdout: String,
        val stderr: String?
    )
}