    // When the user clicks on div, open the popup
    let shown = false;
    function showPopUp() {
    // var popup = document.getElementById("filterPopUp");
    // popup.classList.toggle("show");
        if(shown){
            shown = false;
            $("#filterPopUp").html('');
        }
        else{
            $(".filtersPopUp").css(' position: relative;\n' +
                '    display: inline-block;\n' +
                '    margin-top: 2%;\n' +
                '    width: 50%;\n' +
                '    height: 60%;')

            $("#filterPopUp").append(
                '<div style=" border: #474747 solid 0.01rem;\n' +
                '    border-radius: 2px;\n' +
                '    margin-top: 1%;">'+
                ' <h3 class="card-title">Advanced Search</h3>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Minimum Payment</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <input type="range"/>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Time Span</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <select>\n' +
                '                <option value="" selected disabled hidden>Choose here</option>\n' +
                '                <option>\n' +
                '                    <\n' +
                '                    1 day</option>\n' +
                '                <option>1 day</option>\n' +
                '                <option>1 week</option>\n' +
                '                <option>> month</option>\n' +
                '            </select>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Location</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <select>\n' +
                '                <option value="" selected disabled hidden>Choose here</option>\n' +
                '                <option>Australia</option>\n' +
                '                <option>New Zealand</option>\n' +
                '                <option>Netherlands</option>\n' +
                '                <option>France</option>\n' +
                '            </select>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Level</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <select>\n' +
                '                <option value="" selected disabled hidden>Choose here</option>\n' +
                '                <option>Beginner</option>\n' +
                '                <option>Intermediate</option>\n' +
                '                <option>Expert</option>\n' +
                '            </select>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Type of Marketing</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <select>\n' +
                '                <option value="" selected disabled hidden>Choose here</option>\n' +
                '                <option>1</option>\n' +
                '                <option>2</option>\n' +
                '                <option>3</option>\n' +
                '                <option>4</option>\n' +
                '            </select>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <h6>Language Required</h6>\n' +
                '        </div>\n' +
                '        <div class="col-sm">\n' +
                '            <select>\n' +
                '                <option value="" selected disabled hidden>Choose here</option>\n' +
                '                <option>English</option>\n' +
                '                <option>Dutch</option>\n' +
                '                <option>German</option>\n' +
                '                <option>French</option>\n' +
                '                <option>Hindi</option>\n' +
                '            </select>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="col-sm">\n' +
                '            <button style="float: right" class="btn btn-info" onClick="$(\'#filterBtn\').click()">Confirm</button>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '</div>'
            );
            shown  = true;
        }
        $("#filterPopUp").css('background-color: #FFF;\n' +
            '    color: #474747;\n' +
            '    text-align: left;\n' +
            '    border-radius: 2px;\n' +
            '    position: relative;')

}


