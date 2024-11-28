import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LixoInteligenteEndereco {

    // Classe Endereco
    static class Endereco {
        private String rua;
        private String cep;

        public Endereco(String rua, String cep) {
            this.rua = rua;
            this.cep = cep;
        }

        public String getRua() {
            return rua;
        }

        public String getCep() {
            return cep;
        }

        @Override
        public String toString() {
            return "Rua: " + rua + ", CEP: " + cep;
        }

        public boolean equals(Endereco outro) {
            return this.rua.equals(outro.rua) && this.cep.equals(outro.cep);
        }
    }

    // Classe Morador
    static class Morador {
        private String nome;
        private String email;
        private Endereco endereco;

        public Morador(String nome, String email, Endereco endereco) {
            this.nome = nome;
            this.email = email;
            this.endereco = endereco;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public Endereco getEndereco() {
            return endereco;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + ", E-mail: " + email + ", Endereço: " + endereco;
        }
    }

    // Classe LixoInteligente
    static class LixoInteligente {
        private String id;
        private Endereco endereco;

        public LixoInteligente(String id, Endereco endereco) {
            this.id = id;
            this.endereco = endereco;
        }

        public String getId() {
            return id;
        }

        public Endereco getEndereco() {
            return endereco;
        }

        @Override
        public String toString() {
            return "Sensor ID: " + id + ", Atrelado ao endereço: " + endereco;
        }
    }

    // Classe SensorStatus
    static class SensorStatus {
        private LixoInteligente sensor;
        private int porcentagem;

        public SensorStatus(LixoInteligente sensor, int porcentagem) {
            this.sensor = sensor;
            this.porcentagem = porcentagem;
        }

        public String verificarStatus() {
            String status = "Sensor ID: " + sensor.getId() + " - Endereço: " + sensor.getEndereco() + " - ";

            if (porcentagem == 0) {
                status += "Lixo Vazio";
            } else if (porcentagem == 25) {
                status += "Lixo com 25% de sua capacidade utilizado";
            } else if (porcentagem == 50) {
                status += "Lixo com 50% de sua capacidade utilizado";
            } else if (porcentagem == 75) {
                status += "Lixo com 75% de sua capacidade utilizado";
            } else if (porcentagem == 100) {
                status += "Lixo com 100% de sua capacidade utilizado";
            } else {
                status += "Porcentagem inválida. Deve ser um valor entre 0 e 100.";
            }

            return status;
        }
    }

    // Método Principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de endereços com CEPs
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco("Rua A, 12", "06020-040"));
        enderecos.add(new Endereco("Rua B, 13", "06021-040"));
        enderecos.add(new Endereco("Rua C, 14", "06022-040"));
        enderecos.add(new Endereco("Rua D, 15", "06023-040"));
        enderecos.add(new Endereco("Rua E, 16", "06024-040"));
        enderecos.add(new Endereco("Rua F, 17", "06025-040"));
        enderecos.add(new Endereco("Rua G, 18", "06026-040"));
        enderecos.add(new Endereco("Rua H, 19", "06027-040"));
        enderecos.add(new Endereco("Rua I, 20", "06028-040"));
        enderecos.add(new Endereco("Rua J, 21", "06029-040"));

        // Lista de sensores atrelados aos endereços
        List<LixoInteligente> sensores = new ArrayList<>();
        sensores.add(new LixoInteligente("001", enderecos.get(0)));
        sensores.add(new LixoInteligente("002", enderecos.get(1)));
        sensores.add(new LixoInteligente("003", enderecos.get(2)));
        sensores.add(new LixoInteligente("004", enderecos.get(3)));
        sensores.add(new LixoInteligente("005", enderecos.get(4)));
        sensores.add(new LixoInteligente("006", enderecos.get(0)));
        sensores.add(new LixoInteligente("007", enderecos.get(1)));
        sensores.add(new LixoInteligente("008", enderecos.get(2)));
        sensores.add(new LixoInteligente("009", enderecos.get(3)));
        sensores.add(new LixoInteligente("010", enderecos.get(4)));

        // Lista de moradores
        List<Morador> moradores = new ArrayList<>();

        // Simulação de porcentagens dos sensores
        int[] porcentagens = {0, 25, 50, 75, 100, 50, 25, 75, 0, 100};

        // Menu para o cadastro de moradores
        while (true) {
            System.out.println("\nPonto de Coleta de Lixo Inteligente nas Comunidades!");
            System.out.println("Por favor, faça seu cadastro:");
            System.out.println("1. Cadastre-se (Campo para Usuário)");
            System.out.println("2. Exibir moradores cadastrados (Campo para ADMIN)");
            System.out.println("3. Exibir status dos sensores (Campo para ADMIN)");
            System.out.println("4. Sair");
            System.out.print("Sua escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o \n

            if (opcao == 1) {
                System.out.println("\n=== Cadastro de Morador ===");
                System.out.print("Nome completo: ");
                String nome = scanner.nextLine();
                System.out.print("E-mail: ");
                String email = scanner.nextLine();
                System.out.println("\nPor favor, informe o seu endereço:");

                System.out.print("Rua e número: ");
                String rua = scanner.nextLine();
                System.out.print("CEP: ");
                String cep = scanner.nextLine();

                // Verifica se o endereço e CEP correspondem a um endereço cadastrado
                Endereco enderecoCadastro = null;
                for (Endereco endereco : enderecos) {
                    if (endereco.getRua().equals(rua) && endereco.getCep().equals(cep)) {
                        enderecoCadastro = endereco;
                        break;
                    }
                }

                if (enderecoCadastro != null) {
                    // Cadastro do morador
                    Morador morador = new Morador(nome, email, enderecoCadastro);
                    moradores.add(morador);

                    // Verificando o sensor disponível para esse endereço
                    boolean sensorEncontrado = false;
                    for (int i = 0; i < sensores.size(); i++) {
                        if (sensores.get(i).getEndereco().equals(enderecoCadastro)) {
                            // Exibe o status do sensor
                            SensorStatus status = new SensorStatus(sensores.get(i), porcentagens[i]);
                            System.out.println("\nSensor disponível para o morador: " + sensores.get(i));
                            System.out.println(status.verificarStatus());
                            sensorEncontrado = true;
                            break;
                        }
                    }

                    if (!sensorEncontrado) {
                        System.out.println("Nenhum sensor disponível para este endereço.");
                    }

                    System.out.println("\nCadastro concluído, E-mail enviado para validação!");
                } else {
                    System.out.println("\nEndereço ou CEP inválido. Cadastro não realizado.");
                }
            } else if (opcao == 2) {
                System.out.println("\n=== Moradores cadastrados ===");
                if (moradores.isEmpty()) {
                    System.out.println("Nenhum morador cadastrado.");
                } else {
                    for (Morador morador : moradores) {
                        System.out.println(morador);
                    }
                }
            } else if (opcao == 3) {
                System.out.println("\n=== Status dos Sensores ===");
                for (int i = 0; i < sensores.size(); i++) {
                    SensorStatus status = new SensorStatus(sensores.get(i), porcentagens[i]);
                    System.out.println(status.verificarStatus());
                }
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
