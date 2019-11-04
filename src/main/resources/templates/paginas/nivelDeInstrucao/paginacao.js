var tamanhoPagina = 6;
var pagina = 0;

var dados = [
    ['01', 'Superior', 'Ativo', 'teste'],
	['02', 'Bacharel', 'Inativo', 'teste'],
	['03', 'Tecnologo', 'Ativo', 'teste'],
	['04', 'Pos Graduacao', 'Ativo', 'teste']
];

function paginar() {
    $('.tabelaNivelInstrucao > tbody > tr').remove();
    var tbody = $('.tabelaNivelInstrucao > tbody');
    for (var i = pagina * tamanhoPagina; i < dados.length && i < (pagina + 1) *  tamanhoPagina; i++) {
        tbody.append(
            $('<tr>')
                .append($('<td>').append(dados[i][0]))
                .append($('<td>').append(dados[i][1]))
				.append($('<td>').append(dados[i][2]))
				.append($('<td>').append(dados[i][3]))
        )
    }
    $('#numeracao').text('Página ' + (pagina + 1) + ' de ' + Math.ceil(dados.length / tamanhoPagina));
}

function ajustarBotoes() {
    $('#proximo').prop('disabled', dados.length <= tamanhoPagina || pagina > dados.length / tamanhoPagina - 1);
    $('#anterior').prop('disabled', dados.length <= tamanhoPagina || pagina == 0);
}

$(function() {
    $('#proximo').click(function() {
        if (pagina < dados.length / tamanhoPagina - 1) {
            pagina++;
            paginar();
            ajustarBotoes();
        }
    });
    $('#anterior').click(function() {
        if (pagina > 0) {
            pagina--;
            paginar();
            ajustarBotoes();
        }
    });
    paginar();
    ajustarBotoes();
});