package br.com.igorfv.igorapicliente.repositoy;

import br.com.igorfv.igorapicliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long aLong);


}
