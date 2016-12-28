<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Loading Bootstrap -->
    <link href="../../dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="../../dist/css/flat-ui.css" rel="stylesheet">
</head>
<body>

    <div class="container">

      <h6>Optroups</h6>

      <select data-toggle="select" class="form-control select select-default mrs mbm">
        <optgroup label="Profile">
          <option value="0">My Profile</option>
          <option value="1">My Friends</option>
          <option value="2">Messages</option>
          <option value="3">My Settings</option>
          <option value="4">Logout</option>
        </optgroup>
      </select>


    </div><!-- /.container -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../dist/js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../dist/js/flat-ui.min.js"></script>

    <script src="docs/assets/js/application.js"></script>

    <script>
      $(document).ready(function(){
        $('select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]').select2({dropdownCssClass: 'select-inverse-dropdown'});

        $('select[name="searchfield"]').select2({dropdownCssClass: 'show-select-search'});
        $('select[name="inverse-dropdown-searchfield"]').select2({dropdownCssClass: 'select-inverse-dropdown show-select-search'});
      });
    </script>

  </body>
</html>