let data = [];
$.ajax({
    type: 'GET',
    url: 'data/jobs.json',
    data: data,
    dataType: 'json',
    success: function (data){
        $.each(data, function(index, element) {// purvite 3x31 i 3 tochki ako e nad 3x34
            const card =  '<div class="my-3">\n' +
                '                            <div class="card" style="width: 18rem;">\n' +
                '                                <div class="card-body">\n' +
                '                                    <h5 class="card-title">' + element.company + '</h5>\n' +
                '                                    <p class="card-text">'
                + element.description +
                '</p>\n' +
                '                                    <a href="#" class="btn btn-primary">See more</a>\n' +
                '                                </div>';
            switch (index % 3){
                case 0:
                    $("#col-1").append(
                        card
                    )
                    break;
                case 1:
                    $("#col-2").append(
                        card
                    )
                    break;
                case 2:
                    $("#col-3").append(
                        card
                    )
                    break;
                default: console.log('failed card');
            }
        });
    }
})