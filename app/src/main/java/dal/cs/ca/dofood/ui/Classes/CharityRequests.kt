package dal.cs.ca.dofood.ui.Classes

class CharityRequests {
    var name:String?=null
    var jobRole:String?=null
    var desc: String?=null
    var image:Int?=null
    var maxHours:String?=null
    var minHours:String?=null

    constructor(name: String, jobRole: String, desc : String, image : Int, maxHours : String, minHours : String) {
        this.name = name
        this.jobRole = jobRole
        this.desc = desc
        this.image = image
        this.maxHours = maxHours
        this.minHours = minHours
    }
}