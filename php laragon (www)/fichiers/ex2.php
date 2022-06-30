<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex2</title>
    <link rel="stylesheet" href="styles/ex2.css">
</head>
<body>

    <?php

    $customers = file("files/customers.csv");

    echo "<table>";

    echo "
    <tr>
    <thead>
        <td>Surname</td>
        <td>Firstname</td>
        <td>Email</td>
        <td>Phone</td>
        <td>City</td>
        <td>State</td>
    </thead>
    </tr>";

    echo "<tbody>";

    foreach ($customers as $line) {
        // permet aussi de supprimer les espaces avant et après les virgules.
        $customerData = preg_split("/\s*,\s*/", $line);

        echo "<tr>";
        foreach ($customerData as $v) {
            echo "<td>".$v."</td>";
        }
        echo "</tr>";
        
    }
    echo "</tbody>";
    echo "<table>";

    ?>

</body>
</html>