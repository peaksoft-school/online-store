let form = document.getElementById("form")
var check = function () {
    if (document.getElementById('password').value ==
        document.getElementById('confirmPassword').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'matching';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'not matching';
    }
}

let url = 'http://localhost:9898/users/register';
form.addEventListener('submit', function (e) {
    e.preventDefault()
    let email = document.getElementById('email').value

    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            email: email,
            password : ""
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(function (response) {
            if (response.ok) {
                return response.text()
            }
        })
        .then(function (data) {
            console.log(data)
        })

        setTimeout(test, 1500);

        function test() {
             document.location.href = 'http://localhost:9898'
        }
})

