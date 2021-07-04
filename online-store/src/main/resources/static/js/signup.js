let password = document.getElementById("password")
let confirmPassword = document.getElementById("confirmPassword")
let form = document.getElementById("form")
let msg = document.getElementById("message")


function validate(){
    if (password.value !== confirmPassword.value) {
        msg.classList.remove("hidden")
    }
    else {
        msg.classList.add("hidden")
    }
}

form.addEventListener("submit", (e) => {
    e.preventDefault()
    validate()
})