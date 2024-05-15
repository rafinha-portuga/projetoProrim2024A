(function() {
    $("#tabusuarios").on("click",".js-delete",function() {
        // alert("clicou")
        let botaousuario = $(this)
        $("#btnsim").attr("data-id",botaousuario.attr("data-id"))
        $("#modalusuario").modal("show")
    })
    $("#btnsim").on("click", function(){
        let botaosim = $(this)
        let id = botaosim.attr("data-id")
        $.ajax({
            url: "/usuarios/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/usuarios"
            }
        })
    })
})()