function isPasswordMatch() {
    var password = $("#pass").val();
    var confirmPassword = $("#passcon").val();

    if (password != confirmPassword) $("#divCheckPassword").html("Passwords do not match!");
    else $("#divCheckPassword").html("Passwords match!");
}
