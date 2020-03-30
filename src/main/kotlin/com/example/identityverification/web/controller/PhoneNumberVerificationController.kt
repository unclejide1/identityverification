package com.example.identityverification.web.controller


import com.example.identityverification.usecase.IdVerificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping(value = [""])
class PhoneNumberVerificationController {


    @Autowired
    lateinit var idVerificationService: IdVerificationService

    @RequestMapping("")
    fun verification(): String {
        return "index"
    }

    @RequestMapping( "/verify")
    fun verifyPhoneNumber(@RequestParam idNumber: String): String {
        val result = idVerificationService.verifyIdNumber(idNumber.toUpperCase())

            return "redirect:/?q=$result"

    }
}