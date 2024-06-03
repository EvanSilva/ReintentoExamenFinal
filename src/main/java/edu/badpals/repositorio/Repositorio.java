package edu.badpals.repositorio;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;

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

        for (MagicalItem item: items){

            if (item.getName() == magicalItem.getName() && item.getQuality() == magicalItem.getQuality() && item.getType() == magicalItem.getType()) {
                return MagicalItem.findByIdOptional(item);
            }

        }

        return Optional.empty()
    }
}
