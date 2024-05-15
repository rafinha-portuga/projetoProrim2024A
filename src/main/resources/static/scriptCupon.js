(function() {
    $("#tabcupons").on("click",".js-delete",function() {
        // alert("clicou")
        let botaocupon = $(this)
        $("#btnsim").attr("data-id",botaocupon.attr("data-id"))
        $("#modalcupon").modal("show")
    })
    $("#btnsim").on("click", function(){
        let botaosim = $(this)
        let id = botaosim.attr("data-id")
        $.ajax({
            url: "/cupons/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/cupons"
            }
        })
    })
})()