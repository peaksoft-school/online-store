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
const table = document.querySelector('table')
let url = 'http://localhost:9898/users/newUser';
form.addEventListener('submit', function (e) {
    e.preventDefault()
    let username = document.getElementById('username').value
    let lastName = document.getElementById('lastName').value
    let email = document.getElementById('email').value
    let profilePicture = document.getElementById('profilePicture').value
    let phoneNumber = document.getElementById('phoneNumber').value
    let birthday = document.getElementById('birthday').value
    let password = document.getElementById('password').value
    var data = new FormData(form);
    var output = "";
    for (const entry of data) {
        output = entry[1] + "\r";
    }

    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            username: username,
            lastName: lastName,
            email: email,
            phoneNumber:phoneNumber,
            profilePicture:profilePicture,
            birthDate:birthday,
            gender:output,
            password: password
        }),
        headers: {
            "Content-Type":"application/json"
        }
    })
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            console.log(data)
        })
    setTimeout(test,100);
    function test() {
         document.location.href = 'http://localhost:9898/main_page'
    }
})

