var CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/hyooouyiy/upload';
var CLOUDINARY_UPLOAD_PRESET ='lgyia1gr';

var fileUpload = document.getElementById('url');

fileUpload.addEventListener('change', function (event) {
    var file = event.target.files[0];
    var formData=new FormData();
    formData.append('file', file);
    formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

    axios({
        url: CLOUDINARY_URL,
        method: 'POST',
        headers: {
            'Content-type': 'application/x-www-form-urlencoded'
        },
        data: formData
    }).then(function (res) {
        console.log(res);
    }).catch(function (err) {
        console.error(err);
    });
});