import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Alterar paciente");
            System.out.println("4 - Buscar paciente por IMC");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    cadastrarPaciente(pacientes, scanner);
                    break;
                case 2:
                    listarPacientes(pacientes);
                    break;
                case 3:
                    alterarPaciente(pacientes, scanner);
                    break;
                case 4:
                    buscarPorIMC(pacientes, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (opcao != 5);
        
        scanner.close();
    }
    
    public static void cadastrarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        
        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();
        
        Paciente paciente = new Paciente(nome, idade, peso, altura);
        pacientes.add(paciente);
        
        System.out.println("Paciente cadastrado com sucesso!");
    }
    
    public static void listarPacientes(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        
        System.out.println("Lista de pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }
    
    public static void alterarPaciente(List<Paciente> pacientes, Scanner scanner) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        
        System.out.print("Digite o nome do paciente que deseja alterar: ");
        String nome = scanner.next();
        
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Novo peso (kg): ");
                double peso = scanner.nextDouble();
                
                System.out.print("Nova altura (m): ");
                double altura = scanner.nextDouble();
                
                paciente.setPeso(peso);
                paciente.setAltura(altura);
                
                System.out.println("Paciente alterado com sucesso!");
                return;
            }
        }
        
        System.out.println("Paciente não encontrado.");
    }
    
    public static void buscarPorIMC(List<Paciente> pacientes, Scanner scanner) {
        System.out.print("Digite o IMC desejado para a busca: ");
        double imcDesejado = scanner.nextDouble();
        
        boolean encontrado = false;
        
        for (Paciente paciente : pacientes) {
            double imc = paciente.calcularIMC();
            
            if (imc == imcDesejado) {
                System.out.println("Paciente encontrado:");
                System.out.println(paciente);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Nenhum paciente encontrado com o IMC desejado.");
        }
    }
}

class Paciente {
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    
    public Paciente(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double calcularIMC() {
        return peso / (altura * altura);
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Peso: " + peso + "kg, Altura: " + altura + "m, IMC: " + calcularIMC();
    }
}
