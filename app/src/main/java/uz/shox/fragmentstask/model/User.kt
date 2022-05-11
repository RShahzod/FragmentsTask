package uz.shox.fragmentstask.model

data class User(val name:String,val age:Int){
    override fun toString(): String {
        return "Name: $name \nAge:$age"
    }
}
