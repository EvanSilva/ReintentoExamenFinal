package edu.badpals.repositorio;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.domain.WizardPersona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class Repositorio {

    public Optional<Wizard> loadWizard (String nombre){
        Optional<Wizard> wizard = Wizard.findByIdOptional(nombre);
        return wizard;
    }

    public Optional<MagicalItem> loadItem(String nombre) {
        Optional<MagicalItem> item = MagicalItem.find("name", nombre).firstResultOptional();
        return item;
    }

    public Optional<MagicalItem> loadItem(MagicalItem magicalItem){

        List<MagicalItem> items = MagicalItem.listAll();

        MagicalItem magicalItemFiltered = null;

        for (MagicalItem item: items){

            if (item.getName().equals(magicalItem.getName()) && item.getQuality() == magicalItem.getQuality() && item.getType().equals(magicalItem.getType())) {
                magicalItemFiltered = item;
            }

        }

        return Optional.ofNullable(magicalItemFiltered);

    }

    public List<MagicalItem> loadItems(String nombre) {

        List<MagicalItem> items = MagicalItem.listAll();
        List<MagicalItem> itemsFiltrados = new ArrayList<>();

        for (MagicalItem item : items) {

            if (item.getName().equals(nombre)) {
                itemsFiltrados.add(item);
            }
        }
        return itemsFiltrados;
    }

    @Transactional
    public Optional<Order> placeOrder(String wizard, String magicalItem) {

        Optional<Wizard> mago = Wizard.findByIdOptional(wizard);
        Optional<MagicalItem> itemMagico = MagicalItem.find("name = ?1", magicalItem).firstResultOptional();

        Order ordenFiltrada = null;

        if (mago.isPresent() && itemMagico.isPresent() && mago.get().getPerson().compareTo(WizardPersona.MUDBLOOD) != 0 ) {

            Order orden = new Order(loadWizard(wizard).get(), loadItem(magicalItem).get());

            ordenFiltrada = orden;
            ordenFiltrada.persist();
        }

        return Optional.ofNullable(ordenFiltrada);
    }

    @Transactional
    public MagicalItem createItem(String name, int quality, String type) {

        MagicalItem item = new MagicalItem(name, quality,type);
        item.persist();

        return item;
    }

    @Transactional
    public void createItems(List<MagicalItem> listaItems){

        for (MagicalItem item: listaItems) {

            item.persist();

        }

    }

    @Transactional
    public void deleteItem(MagicalItem item) {

       Optional<MagicalItem> itemToKill = loadItem(item);

       if (itemToKill.isPresent()) {
           MagicalItem.delete("name = ?1", itemToKill.get().getName());

       }

    }


}
