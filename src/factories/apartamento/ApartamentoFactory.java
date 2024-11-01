package factories.apartamento;

import modelos.Morador;
import modelos.apartamento.Apartamento;

import java.util.List;

public abstract class ApartamentoFactory {
    public abstract Apartamento criarApartamento(int numero, int andar, List<Morador> listaMoradores);
}
