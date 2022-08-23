import java.sql.DriverManager

data class Passanger(val P_Id:Int,val P_name:String,val P_age:Int,val gender:String,val phone:String)

fun main() {
    val JDBCURL = "jdbc:mysql://localhost:3306/OTB"
    val connection = DriverManager.getConnection(JDBCURL, "root", "root")
//    println(connection.isValid(0))


    //code for inserting values into the table
//    val statement =
//        connection.createStatement().executeUpdate("insert into passenger values(002,'KIRAN',43,'Male','1234567890')")
//    if (statement > 0) {
//        println("Inserted Successfully")
//    } else {
//        println("Not Successfull")
//    }



    //Code for updating the record
//    val res_update = connection.createStatement()
//        .executeUpdate("update Passenger set P_name='Rohini',P_age=45,gender='Female' where P_Id=002")
//    if(res_update > 0){
//        println("Successfully updated a record into Database")
//    }
//    else{
//        println("Updation not successful")
//    }




    //------------ Displaying the table -------------------------
    val query = connection.prepareStatement("select *  from passenger")
    val result = query.executeQuery()
    val Passenger = mutableListOf<Passanger>()
    while (result.next()) {
        val passenger_id = result.getInt("P_id")
        val passenger_name = result.getString("P_name")
        val passenger_age = result.getInt("P_age")
        val passenger_gender = result.getString("gender")
        val passenger_phone = result.getString("phone")
        Passenger.add(Passanger(passenger_id,passenger_name,passenger_age,passenger_gender,passenger_phone))

    }
    println(Passenger)
}


