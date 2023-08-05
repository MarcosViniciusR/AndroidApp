package com.example.meuapp.domain

class LoginService {
    fun login(login: String, senha: String): Usuario? {
        if(login == "marcos" && senha == "123"){
            return Usuario("Marcos", "@email.com")
        } else if(login == "luiza" && senha == "123"){
            return Usuario("Luiza", "@email.com")
        }
        return null
    }
}