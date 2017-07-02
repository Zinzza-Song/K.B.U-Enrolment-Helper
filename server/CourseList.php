<?php

header("Content-Type: text/html; charset=UTF-8");
$con = mysqli_connect("localhost", "thdgksq", "kjhpro159357", "thdgksq");

$courseUniversity = $_GET["courseUniversity"];
$courseGrade = $_GET["courseGrade"];
$courseTerm = $_GET["courseTerm"];
$courseArea = $_GET["courseArea"];
$courseMajor = $_GET["courseMajor"];

$result = mysqli_query($con, "SELECT * FROM course WHERE courseUniversity='$courseUniversity' AND courseGrade='$courseGrade' AND courseTerm='$courseTerm' AND courseArea='$courseArea' AND courseMajor='$courseMajor'");

$responsse = array();

while($row = mysqli_fetch_array($result)){
    array_push($responsse, array("courseID"=>$row[0], "courseUniversity"=>$row[1], "courseTerm"=>$row[2], "courseArea"=>$row[3], "courseMajor"=>$row[4], "courseGrade"=>$row[5], "courseTitle"=>$row[6], "courseCredit"=>$row[7], "coursePersonnel"=>$row[8], "courseProfessor"=>$row[9], "courseTime"=>$row[10], "courseRoom"=>$row[11]));
}

echo json_encode(array("response"=>$responsse), JSON_UNESCAPED_UNICODE);
mysqli_close($con);

?>