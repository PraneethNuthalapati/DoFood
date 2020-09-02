package dal.cs.ca.dofood.ui.Classes

class History {
    var name:String?=null
    var jobPosition:String?=null
    var image:Int?=null
    var hoursWorked :String?=null
    var timeFrame :String?=null

    constructor(name: String, jobPosition: String, hoursWorked : String, image : Int, timeFrame :String) {
        this.name = name
        this.jobPosition = jobPosition
        this.hoursWorked = hoursWorked
        this.image = image
        this.timeFrame = timeFrame
    }
}