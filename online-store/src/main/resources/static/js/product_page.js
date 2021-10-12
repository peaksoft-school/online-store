let html_about_product;
let table2 = document.getElementById('productL');
let idEl = localStorage.getItem('selectedProduct');
let url = `http://localhost:9898`;
fetch(`${url + '/products/getById/'+ idEl}`, {
    method: 'GET',
}).then(data => {
    return data.json();
}).then((about_product) => {
    html_about_product += `
                         <div class="col-md-12" style="display: flex; flex-wrap: wrap">
                    <div class="col-md-6" >
                      <img src="${about_product.productPicture}" alt=""
                             width="420" height="400">
                    </div>
                    <div class="col-md-6">
                    <p ><b>Имя: </b>${about_product.name}</p>
                        <p ><b>Цена: </b>${about_product.productPrice}</p>
                        <p ><b>Производитель: </b>${about_product.description.productManufacturer}</p>
                        <p><b>Гарантия: </b>${about_product.description.productGuarantee}</p>
                        <p><b>Цвет: </b>${about_product.description.productColor}</p>
                        <p><b>Размер: </b>${about_product.description.productDimensions}</p>
                        <p><b>Вес: </b>${about_product.description.productWeight}</p>
                        </div>
                    </div>
`;
    $(document).ready(function(){
        $('#textarea-id').click(function(){
            var styles = {
                height: "55px",
                overflow: "hidden",
                display: "block"
            };
            $('.btn-outer').slideDown();
            $('#textarea-id').css(styles);
        });
        $('#cancel-id').click(function (){
            $('.btn-outer').val('').slideUp();
            $('#textarea-id').css("height", "27px");
        });
    });
    var textarea = document.querySelector('textarea');
    textarea.addEventListener('keydown', autosize);
    function autosize(){
        var el = this;
        setTimeout(function(){
            el.style.cssText = 'height:auto; padding:0';
            el.style.cssText = 'height:' + el.scrollHeight + 'px';
        }, 0);
    }

    let userId = null;
    let productId = about_product.id;
     fetch(url + '/users/user')
        .then(response => response.json())
        .then(value => {
            userId = value.id;
    const create = document.getElementById('form-input-id');
    create.addEventListener('submit', async function (event) {
        event.preventDefault();
        let commentSave = document.getElementById('textarea-id').value;
        await fetch(url + "/comment/" + productId + "/" + userId, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                comment: commentSave
            })
        });
        location.reload(true);
    })
});



    let commentList = document.getElementById('comment-list');
    let param = '';
    about_product.productComments.forEach(function (iter){
    let fetchComments = `
<div class="div-one" style="border: 1px solid gray">
    <div class="div-two" style="display: flex">
        <div class="div-main-picture-class">
            <img src="${iter.user.profilePicture}" class="picture-class">
        </div>
        <div class="div-main-comment-class">
            <div class="user-name-over-comment">
                <p class="text-id">
                    ${iter.user.username}
                </p>
            </div>
            <div class="comment-class">
            <p class="text-id">
                ${iter.comment}
            </p>
            </div>
            <div class="answer-for-comment">
                <p class="text-id">answer in thread</p>
            </div>
            <div class="comment-thread-class">
                <p class="text-id">threads</p>
            </div>
        </div>
        <div class="div-main-button-class">
            <div onclick="myFunction(e)" id="three-dots-id" >
<!--            <button onclick="return myFunction();">Button</button>-->
                <div class="three-dots">
                
                    <figure class="figure-id"></figure>
                    <figure class="figure-id"></figure>
                    <figure class="figure-id"></figure>
               
                </div>
            </div>
            <div class="update-delete-classes" id="modal-block-id">
                <div class="update-class-one">
                    <a>Edit</a>
                </div>
                <div class="delete-class-one">
                    <a>Remove</a>
                </div>
            </div>
        </div>
    </div>
</div>
`;

           param += fetchComments;
});


    commentList.innerHTML = param;
    table2.innerHTML = html_about_product;
})
// let hrefValue = document.getElementById('three-dots');
// let modalValue = document.getElementById('modal-id');
// hrefValue.click = function () {
//     modalValue.style.display = "block";
// }
//     $(document).ready(function (){
//         $('this').find('.three-dots').click(function (){
//             $("#modal-block-id").css('display', 'block');
//         });
//         // css('display', 'block');
//         // $('#modal-block-id').slideDown();
//     });
function myFunction(e) {
    console.log(ev.e.target.value)
    console.log("reached")
    let ev = document.getElementById("modal-block-id");
    if (e.target.value.style.display === "none") {
        e.target.value.style.display = "block";
    } else {
        e.target.value.style.display = "none";
    }

}

myFunction(e)

console