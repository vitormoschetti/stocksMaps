package br.com.stocksmaps.domain.services;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.factories.CarteiraInputModelParaCarteira;
import br.com.stocksmaps.application.factories.CarteiraParaCarteiraViewModel;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.repositories.ICarteiraRepository;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import br.com.stocksmaps.infra.adapters.hgBrasil.HGBrasilHttpClient;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Service
public class CarteiraService implements ICarteiraService {

    private final HGBrasilHttpClient hgBrasilHttpClient;
    private final ICarteiraRepository repository;
    private final CarteiraInputModelParaCarteira factoryEntity;
    private final CarteiraParaCarteiraViewModel factoryViewModel;

    public CarteiraService(HGBrasilHttpClient hgBrasilHttpClient, ICarteiraRepository repository,
                           CarteiraInputModelParaCarteira factoryEntity, CarteiraParaCarteiraViewModel factoryViewModel) {
        this.hgBrasilHttpClient = hgBrasilHttpClient;
        this.repository = repository;
        this.factoryEntity = factoryEntity;
        this.factoryViewModel = factoryViewModel;
    }

    @Override
    public CarteiraViewModel criarCarteira(CarteiraInputModel carteiraInputModel) {

        final var carteira = this.factoryEntity.create(carteiraInputModel);

        final var entity = this.repository.criar(carteira);

        return this.factoryViewModel.create(entity);
    }

    @Override
    public Carteira sincronizarAtivos(Long idCarteira) {
        final var carteira = this.repository.buscarPorId(idCarteira);

        sincronizarAcoes(carteira);
        sincronizarFiis(carteira);
        sincronizarStocks(carteira);

        return this.repository.atualizar(carteira);

    }

    private void sincronizarStocks(Carteira carteira) {
            carteira.getStocks().forEach(stock -> {
        try {
                final var stockYF = YahooFinance.get(stock.getCodigo());
//                final var dollarYF = YahooFinance.getFx("USDBRL=X");
                stock.sincronizar(stockYF);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            });
    }

    private void sincronizarAcoes(Carteira carteira) {
        carteira.getAcoes().forEach(acao -> {
            final var acaoInputModel = this.hgBrasilHttpClient.obterAtivo(acao.getCodigo());
            acao.sincronizar(acaoInputModel);
        });
    }

    private void sincronizarFiis(Carteira carteira) {
        carteira.getFundosImobiliarios().forEach(fii -> {
            final var acaoInputModel = this.hgBrasilHttpClient.obterAtivo(fii.getCodigo());
            fii.sincronizar(acaoInputModel);
        });
    }


}
