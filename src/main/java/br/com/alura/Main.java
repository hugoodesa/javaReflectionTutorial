package br.com.alura;

import br.com.alura.model.domain.Produto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Produto> produtoClass = Produto.class;

        //contrutor public sem argumentos
        Constructor<Produto> constructor = produtoClass.getConstructor();
        Produto produto = constructor.newInstance();

        //printando os métodos da classe e super classe
        for (Method method : produtoClass.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println("==============");

        //printando somente os métodos da classe mais utilizado
        for (Method metodoDaClasseProduto : Produto.class.getDeclaredMethods()) {
            System.out.println("Printei para para ir em uma branch nova");
            System.out.println("Printei para para ir em uma branch nova");
            System.out.println(metodoDaClasseProduto);
        }

        //criar uma instancia de um objeto atraves de um construtor privado
        Constructor<Produto> declaredConstructor = produtoClass.getDeclaredConstructor(String.class);//criando o contrutor e dizendo quais tipos de parametro ele deve receber
        declaredConstructor.setAccessible(true);//colocando permissão para acessar o construtor
        Produto hugo = declaredConstructor.newInstance("Hugo");//passando para uma instancia do objeto
        System.out.println(hugo);

        //executar um método privado sem argumentos e sem retorno
        Method printInfo = produtoClass.getMethod("printInfo");//passar como parametro o nome do método
        printInfo.setAccessible(true);//quando o método for privado é necessário dar permissão
        printInfo.invoke(produto);//passar como parametro uma instancia da classe

        //executar um método privado que recebe uma String e retornar uma string
        Method metodoPrivadoRetornaString = produtoClass.getDeclaredMethod("metodoPrivadoRetornaString", String.class);
        metodoPrivadoRetornaString.setAccessible(true);//colocar como acessível pois é privado
        // passar o nome do método e depois a classe que representa o tipo do argumento que o método espera
        Object fui_passado_reflection = metodoPrivadoRetornaString.invoke(produto, "Fui passado reflection");
        //instancia da classe e depois o argumento
        System.out.println(fui_passado_reflection);

    }
}