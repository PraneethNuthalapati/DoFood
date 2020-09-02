package dal.cs.ca.dofood.ui.Classes

class PastDonor {
    var donor_name:String? = null
    var image:Int? = null
    var Area:String? = null
    var Restaurant_Name:String? = null

    constructor(a:String,b:Int,c:String,d:String)
    {
        this.donor_name = a
        this.image = b
        this.Area = c
        this.Restaurant_Name = d
    }
}