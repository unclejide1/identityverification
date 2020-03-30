package com.example.identityverification.usecase.impl


import com.example.identityverification.usecase.IdVerificationService
import org.springframework.stereotype.Service


@Service
class IdVerificationServiceImpl: IdVerificationService {

    override fun verifyIdNumber(idNumber: String): String{


        var driversLicense: String = """[A-Z]{3}[0-9]{5}[A-Z]"""
        var internationalPassport: String = """[A-Z][0-9]{8}"""
        var votersCardPattern: String = """([0-9A-Z]{16}?[0-9]{3})|([0-9A-Z]{17}?[0-9]{2})"""





        val driversLicenseRegex = driversLicense.toRegex()
        val votersCardNumberRegex = votersCardPattern.toRegex()
        val internationalPassportRegex = internationalPassport.toRegex()



        val idNumberLength = idNumber.length

        if(idNumberLength in 11..12){
            var driverLicenceExtract = idNumber.take(9)
            if(driversLicenseRegex.containsMatchIn(driverLicenceExtract)) {
                return  "$idNumber is a valid driver's license number"
            }
        }

        if(idNumberLength == 9 ){
            if(internationalPassportRegex.containsMatchIn(idNumber)) {
                return  "$idNumber is a valid International Passport"
            }
        }

        if (idNumberLength == 19){
            if(votersCardNumberRegex.matches(idNumber)){
                return  "$idNumber is a valid Voter's card"
            }
        }




        return "Invalid Id"

    }
}
