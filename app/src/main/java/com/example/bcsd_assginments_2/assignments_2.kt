package com.example.bcsd_assginments_2

fun main(){
    val array1 = listOf(1,3,5,7,9)
    val array2 = listOf(1,3,6,8,0)

    val list3 = array1.union(array2)
    val list4 = listOf(1,2,3,4,5,6,7,8)

    println("question1 : " + list3)

    println("question2 : " + list4.nSkip())
    println(">original : " + list4)

    printAssignments()

}

fun <T> List<T>.nSkip(n : Int = 2) : List<T>{
    return this.filterIndexed{ a, value -> a % n == 0}
}

open class BCSDLabUser(var name:String, var emoji:String){
    open fun printUsers(){
        print(name)
    }
}

class Beginner(name:String, var noAssignment:Int):BCSDLabUser(name, "Seed"){
    override fun printUsers(){
        println("Name : ${name} [${emoji}] / Didn't do assignment : ${noAssignment}")
    }
}

class Regular(name:String, var paid:Boolean):BCSDLabUser(name, "GreenApple"){
    override fun printUsers(){
        println("Name : ${name} [${emoji}] / IsPaid : ${paid}")
    }
}

class Mentor(name:String, var email:String?=null):BCSDLabUser(name, "Star") {
    override fun printUsers(){
        println("Name : ${name} [${emoji}] / Email Address : ${email}")
    }
}


fun printAssignments(){
    val users: List<BCSDLabUser> = listOf(
        Beginner("KongWooJin", 13),
        Beginner("KimDoHun", 1),
        Beginner("Kim0Chan", 3),
        Beginner("YangKkoChi", 1),
        Regular("KwonJin", true),
        Regular("KimBoSeong", false),
        Regular("YangEuiJi", true),
        Mentor("KimSeokHyeon"),
        Mentor("KingSangJin", "sangjin070203@koreatech.ac.kr")
    )

    val beginners = users.filterIsInstance<Beginner>()
    val regulars = users.filterIsInstance<Regular>()
    val mentors = users.filterIsInstance<Mentor>()

    for(user in beginners){
        val c1 = Beginner(user.name, user.noAssignment)
        c1.printUsers()
    }
    for(user in regulars){
        val c2 = Regular(user.name, user.paid)
        c2.printUsers()
    }
    for(user in mentors){
        val c3 = Mentor(user.name, user.email)
        c3.printUsers()
    }

    val beginnerCheck = users.filterIsInstance<Beginner>().filter {it.noAssignment >=3} //과제 미이행 수 체크
    println("---Didn't do Assignments more than 3 times---") //과제 3회 이상 안한 분들
    for(beginner in beginnerCheck){
        println("${beginner.name} [${beginner.emoji}]")
    }

    val regularCheck = users.filterIsInstance<Regular>().filter{it.paid == false}
    println("---Didn't pay money--------------------------")
    for(regular in regularCheck){
        println("${regular.name} [${regular.emoji}]")
    }

    val checkYang = users.filterIsInstance<BCSDLabUser>().filter{it.name.startsWith("Yang")}
    println("---Person whose name starts with Yang--------") //양씨
    for(user in checkYang){
        println("${user.name} [${user.emoji}]")
    }
}


