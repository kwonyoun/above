<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
        <script th:inline="javascript">
        
            window.onload = function() {
                let nextPage = [[${nextPage}]]
                let msg = [[${msg}]];
        
                alert(msg);
                location.href = nextPage;
            }
        
        
        </script>
    
</body>
</html>