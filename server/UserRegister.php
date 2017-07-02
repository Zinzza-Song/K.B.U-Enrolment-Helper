<?php

    $con = mysqli_connect("localhost", "thdgksq", "kjhpro159357", "thdgksq");

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userGender = $_POST["userGender"];
    $userMajor = $_POST["userMajor"];
    $userEmail = $_POST["userEmail"];
    $userName = $_POST["userName"];
    $userNum = $_POST["userNum"];

    $statement = mysqli_prepare($con, "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssssss", $userID, $userPassword, $userGender, $userMajor, $userEmail, $userName, $userNum);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;
    
    echo json_encode($response);

?>