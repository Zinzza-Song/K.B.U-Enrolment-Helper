<?php

$con = mysqli_connect("localhost", "thdgksq", "kjhpro159357", "thdgksq");

$userID = $_POST["userID"];
$courseID = $_POST["courseID"];
$re_courseID = (int)$courseID;

$statement = mysqli_prepare($com, "DELETE FROM schedule WHERE userID = ? AND courseID = ?");
mysqli_stmt_bind_param($statement, "si", $userID, $re_courseID);
mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;

echo json_encode($response);

?>