tinymce.init({
    selector: '#description',
    plugins: 'image',
    images_reuse_filename: true,
    automatic_uploads: true,
    images_upload_handler: uploadImageToFirebase,
});

// Firebase Storage에 이미지 업로드하는 함수
function uploadImageToFirebase(blobInfo, success, failure) {
    const formData = new FormData();
    formData.append('file', blobInfo.blob(), blobInfo.filename());

    axios.post('/upload_image_to_firebase', formData)
        .then(response => {
            const imageUrl = response.data.location;
            success(imageUrl);
        })
        .catch(error => {
            console.error('Error: ', error);
            failure('HTTP Error: ' + error.response.status);
        });
}
