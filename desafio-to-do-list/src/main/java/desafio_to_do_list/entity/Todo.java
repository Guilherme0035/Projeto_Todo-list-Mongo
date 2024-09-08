package desafio_to_do_list.entity;


import com.mongodb.lang.NonNull;
import com.sun.istack.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Todo  implements Serializable {

    @Id
    private String id;
    private String name;
    private String descricao;
    private Boolean realizada;
    private Integer prioridade;

    public Todo(){
    }

    public Todo(String name, String descricao, Boolean realizada, Integer prioridade) {
        this.name = name;
        this.descricao = descricao;
        this.realizada = realizada;
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", realiazada=" + realizada +
                ", prioridade=" + prioridade +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getRealiazada() {
        return realizada;
    }

    public void setRealiazada(Boolean realiazada) {
        this.realizada = realiazada;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
}
