<?php

header("Content-Type: text/html; charset=UTF-8");
$con = mysqli_connect("localhost", "thdgksq", "kjhpro159357", "thdgksq");

$userID = $_GET["userID"];

$result = mysqli_query($con, "SELECT course.courseID, course.courseGrade, course.courseTitle, course.coursePersonnel, COUNT(schedule.courseID), course.courseCredit FROM schedule, course WHERE schedule.courseID IN(SELECT schedule.courseID FROM schedule WHERE schedule.userID='$userID') AND schedule.courseID = course.courseID GROUP BY schedule.courseID");

$response = array();

while($row = mysqli_fetch_array($result)){
    array_push($response, array("courseID"=>$row[0], "courseGrade"=>$row[1], "courseTitle"=>$row[2], "coursePersonnel"=>$row[3], "COUNT(schedule.courseID)"=>$row[4], "courseCredit"=>$row[5]));
}

echo json_encode(array("response"=>$response), JSON_UNESCAPED_UNICODE);
mysqli_close($con);

?>