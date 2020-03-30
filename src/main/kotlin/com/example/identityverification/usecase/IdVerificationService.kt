package com.example.identityverification.usecase

interface IdVerificationService {
    fun verifyIdNumber(idNumber: String): String
}