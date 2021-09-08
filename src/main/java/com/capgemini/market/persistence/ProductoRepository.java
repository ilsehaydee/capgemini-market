package com.capgemini.market.persistence;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.repository.ProductRepository;
import com.capgemini.market.persistence.crud.ProductoCrudRepository;
import com.capgemini.market.persistence.entity.Producto;
import com.capgemini.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Especifico para indicar que es un componente que interactua con la BD
//@Component //Generalizacion // se utiliza en clases genericas
public class ProductoRepository implements ProductRepository {
    @Autowired // los objetos que reciben esta notacion le cedemos el control a spring para que haga las instancias
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts((productos)));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(Integer quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Integer productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public void save(Producto producto) {
        productoCrudRepository.save(producto);
    }

    public void deleteById(Integer id) {
        productoCrudRepository.deleteById(id);
    }

    public Long getCountRegister() {
        return productoCrudRepository.count();
    }


    public Optional<Producto> getProduto(Integer idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

@Override
   public void delete(Integer idProducto) {
        productoCrudRepository.deleteById(idProducto);
   }

    @Override

    public Product updateNameProduct(String name, Integer productId) {
        return mapper.toProduct(productoCrudRepository.actualizarNombreProducto(name, productId));
    }
}
