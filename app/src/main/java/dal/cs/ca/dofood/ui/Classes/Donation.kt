package dal.cs.ca.dofood.ui.Classes

class Donation {

    var charity_name:String? = null
    var image:Int? = null
    var date:String? = null
    var feedback:String? = null

    constructor(a:String,b:Int,c:String,d:String)
    {
        this.charity_name = a
        this.image = b
        this.date = c
        this.feedback = d
    }
}