package view;

import java.util.Scanner;

import dao.CargaDAO;
import dao.ClienteDAO;
import dao.EntregaDAO;
import dao.FuncionarioDAO;
import dao.MotoristaDAO;
import dao.VeiculoDAO;
import model.Carga;
import model.Cliente;
import model.Entrega;
import model.Funcionario;
import model.Motorista;
import model.Veiculo;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n=== Sistema de Transporte de Cargas ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Motoristas");
            System.out.println("4. Gerenciar Veículos");
            System.out.println("5. Gerenciar Cargas");
            System.out.println("6. Gerenciar Entregas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    gerenciarClientes(scanner);
                    break;
                case 2:
                    gerenciarFuncionarios(scanner);
                    break;
                case 3:
                    gerenciarMotoristas(scanner);
                    break;
                case 4:
                    gerenciarVeiculos(scanner);
                    break;
                case 5:
                    gerenciarCargas(scanner);
                    break;
                case 6:
                    gerenciarEntregas(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void gerenciarClientes(Scanner scanner) {
        ClienteDAO clienteDAO = new ClienteDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Clientes ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.next());
                    System.out.print("Endereço: ");
                    cliente.setEndereco(scanner.nextLine());
                    cliente.setEndereco(scanner.next());
                    System.out.print("Telefone: ");
                    cliente.setTelefone(scanner.next());
                    System.out.print("CPF: ");
                    cliente.setCpf(scanner.next());
                    clienteDAO.inserir(cliente);
                    break;
                case 2:
                    System.out.println("Lista de Clientes:");
                    List<Cliente> clientes = clienteDAO.listarTodos();
                    for (Cliente c : clientes) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }
                    break;
                case 3:
                    System.out.print("ID do Cliente a ser atualizado: ");
                    int id = scanner.nextInt();
                    Cliente clienteAtualizar = clienteDAO.buscarPorId(id);
                    if (clienteAtualizar != null) {
                        System.out.print("Novo Nome: ");
                        clienteAtualizar.setNome(scanner.next());
                        System.out.print("Novo Endereço: ");
                        clienteAtualizar.setEndereco(scanner.next());
                        System.out.print("Novo Telefone: ");
                        clienteAtualizar.setTelefone(scanner.next());
                        System.out.print("Novo CPF: ");
                        clienteAtualizar.setCpf(scanner.next());
                        clienteDAO.atualizar(clienteAtualizar);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do Cliente a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    clienteDAO.excluir(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarFuncionarios(Scanner scanner) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Funcionario funcionario = new Funcionario();
                    System.out.print("Nome: ");
                    funcionario.setNome(scanner.next());
                    System.out.print("Endereço: ");
                    funcionario.setEndereco(scanner.next());
                    System.out.print("Telefone: ");
                    funcionario.setTelefone(scanner.next());
                    System.out.print("Cargo: ");
                    funcionario.setCargo(scanner.next());
                    System.out.print("Salário: ");
                    funcionario.setSalario(scanner.nextDouble());
                    funcionarioDAO.inserir(funcionario);
                    break;
                case 2:
                    System.out.println("Lista de Funcionários:");
                    List<Funcionario> funcionarios = funcionarioDAO.listarTodos();
                    for (Funcionario f : funcionarios) {
                        System.out.println(f.getId() + " - " + f.getNome());
                    }
                    break;
                case 3:
                    System.out.print("ID do Funcionário a ser atualizado: ");
                    int id = scanner.nextInt();
                    Funcionario funcionarioAtualizar = funcionarioDAO.buscarPorId(id);
                    if (funcionarioAtualizar != null) {
                        System.out.print("Novo Nome: ");
                        funcionarioAtualizar.setNome(scanner.next());
                        System.out.print("Novo Endereço: ");
                        funcionarioAtualizar.setEndereco(scanner.next());
                        System.out.print("Novo Telefone: ");
                        funcionarioAtualizar.setTelefone(scanner.next());
                        System.out.print("Novo Cargo: ");
                        funcionarioAtualizar.setCargo(scanner.next());
                        System.out.print("Novo Salário: ");
                        funcionarioAtualizar.setSalario(scanner.nextDouble());
                        funcionarioDAO.atualizar(funcionarioAtualizar);
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do Funcionário a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    funcionarioDAO.excluir(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarMotoristas(Scanner scanner) {
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Motoristas ===");
            System.out.println("1. Adicionar Motorista");
            System.out.println("2. Listar Motoristas");
            System.out.println("3. Atualizar Motorista");
            System.out.println("4. Excluir Motorista");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Motorista motorista = new Motorista();
                    System.out.print("Nome: ");
                    motorista.setNome(scanner.next());
                    System.out.print("Endereço: ");
                    motorista.setEndereco(scanner.next());
                    System.out.print("Telefone: ");
                    motorista.setTelefone(scanner.next());
                    System.out.print("Cargo: ");
                    motorista.setCargo(scanner.next());
                    System.out.print("Salário: ");
                    motorista.setSalario(scanner.nextDouble());
                    System.out.print("CNH: ");
                    motorista.setCnh(scanner.next());
                    System.out.print("Rota: ");
                    motorista.setRota(scanner.next());
                    motoristaDAO.inserir(motorista);
                    break;
                case 2:
                    System.out.println("Lista de Motoristas:");
                    List<Motorista> motoristas = motoristaDAO.listarTodos();
                    for (Motorista m : motoristas) {
                        System.out.println(m.getId() + " - " + m.getNome());
                    }
                    break;
                case 3:
                    System.out.print("ID do Motorista a ser atualizado: ");
                    int id = scanner.nextInt();
                    Motorista motoristaAtualizar = motoristaDAO.buscarPorId(id);
                    if (motoristaAtualizar != null) {
                        System.out.print("Novo Nome: ");
                        motoristaAtualizar.setNome(scanner.next());
                        System.out.print("Novo Endereço: ");
                        motoristaAtualizar.setEndereco(scanner.next());
                        System.out.print("Novo Telefone: ");
                        motoristaAtualizar.setTelefone(scanner.next());
                        System.out.print("Novo Cargo: ");
                        motoristaAtualizar.setCargo(scanner.next());
                        System.out.print("Novo Salário: ");
                        motoristaAtualizar.setSalario(scanner.nextDouble());
                        System.out.print("Nova CNH: ");
                        motoristaAtualizar.setCnh(scanner.next());
                        System.out.print("Nova Rota: ");
                        motoristaAtualizar.setRota(scanner.next());
                        motoristaDAO.atualizar(motoristaAtualizar);
                    } else {
                        System.out.println("Motorista não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do Motorista a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    motoristaDAO.excluir(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarVeiculos(Scanner scanner) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Veículos ===");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Excluir Veículo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    System.out.print("Placa: ");
                    veiculo.setPlaca(scanner.next());
                    System.out.print("Modelo: ");
                    veiculo.setModelo(scanner.next());
                    System.out.print("Capacidade (Kg): ");
                    veiculo.setCapacidadeKg(scanner.nextDouble());
                    veiculoDAO.inserir(veiculo);
                    break;
                case 2:
                    System.out.println("Lista de Veículos:");
                    List<Veiculo> veiculos = veiculoDAO.listarTodos();
                    for (Veiculo v : veiculos) {
                        System.out.println(v.getId() + " - " + v.getModelo() + "-" + v.getPlaca());
                    }
                    break;
                case 3:
                    System.out.print("ID do Veículo a ser atualizado: ");
                    int id = scanner.nextInt();
                    Veiculo veiculoAtualizar = veiculoDAO.buscarPorId(id);
                    if (veiculoAtualizar != null) {
                        System.out.print("Nova Placa: ");
                        veiculoAtualizar.setPlaca(scanner.next());
                        System.out.print("Novo Modelo: ");
                        veiculoAtualizar.setModelo(scanner.next());
                        System.out.print("Nova Capacidade (Kg): ");
                        veiculoAtualizar.setCapacidadeKg(scanner.nextDouble());
                        veiculoDAO.atualizar(veiculoAtualizar);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do Veículo a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    veiculoDAO.excluir(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarCargas(Scanner scanner) {
        CargaDAO cargaDAO = new CargaDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Cargas ===");
            System.out.println("1. Adicionar Carga");
            System.out.println("2. Listar Cargas");
            System.out.println("3. Atualizar Carga");
            System.out.println("4. Excluir Carga");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Carga carga = new Carga();
                    System.out.print("Descrição: ");
                    scanner.nextLine();
                    carga.setDescricao(scanner.nextLine());
                    System.out.print("Peso (Kg): ");
                    carga.setPeso(scanner.nextDouble());
                    System.out.print("Volume (m³): ");
                    carga.setVolume(scanner.nextDouble());
                    carga.setEmRota(false);
                    cargaDAO.inserir(carga);
                    break;
                case 2:
                    System.out.println("Lista de Cargas:");
                    List<Carga> cargas = cargaDAO.listarTodos();
                    for (Carga c : cargas) {
                        System.out.println(c.getId() + " - " + c.getDescricao());
                    }
                    break;
                case 3:
                    System.out.print("ID da Carga a ser atualizada: ");
                    int id = scanner.nextInt();
                    Carga cargaAtualizar = cargaDAO.buscarPorId(id);
                    if (cargaAtualizar != null) {
                        System.out.print("Nova Descrição: ");
                        cargaAtualizar.setDescricao(scanner.next());
                        System.out.print("Novo Peso (Kg): ");
                        cargaAtualizar.setPeso(scanner.nextDouble());
                        System.out.print("Novo Volume (m³): ");
                        cargaAtualizar.setVolume(scanner.nextDouble());
                        System.out.println("Status rota: (true or false)");
                        cargaAtualizar.setEmRota(scanner.nextBoolean());
                        cargaDAO.atualizar(cargaAtualizar);
                    } else {
                        System.out.println("Carga não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("ID da Carga a ser excluída: ");
                    int idExcluir = scanner.nextInt();
                    cargaDAO.excluir(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarEntregas(Scanner scanner) {
     	EntregaDAO entregaDAO = new EntregaDAO();
        int opcao;

        do {
            System.out.println("\n=== Gerenciar Entregas ===");
            System.out.println("1. Adicionar Entrega");
            System.out.println("2. Listar Entregas");
            System.out.println("3. Atualizar Entrega");
            System.out.println("4. Excluir Entrega");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Entrega entrega = new Entrega();
                    
                    System.out.println("ID do Cliente");
                    Cliente cliente= new Cliente();
                    cliente.setId(scanner.nextInt());
                    entrega.setCliente(cliente);
                    
                    System.out.println("ID do Motorista");
                    Motorista motorista = new Motorista();
                    motorista.setId(scanner.nextInt());
                    entrega.setMotorista(motorista);
                    
                    System.out.println("ID do Veículo: ");
                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(scanner.nextInt());
                    entrega.setVeiculo(veiculo);
                    
                    System.out.println("ID da Carga: ");
                    Carga carga = new Carga();
                    carga.setId(scanner.nextInt());
                    entrega.setCarga(carga);
                    
                    scanner.nextLine();
                    System.out.println("Status da Entrega: ");
                    entrega.setStatus(scanner.nextLine());
                    
                    System.out.println("Data de saída(AAAA-MM-DD): ");
                    entrega.setDtSaida(Date.valueOf(scanner.next()));
                    
                    System.out.println("Previsão de entrega(AAAA-MM-DD): ");
                    entrega.setDtEntrega(Date.valueOf(scanner.next()));
                    
                    entregaDAO.inserir(entrega);
                    System.out.println("Entrega adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("\nLista de Entregas:");
                    List<Entrega> entregas = entregaDAO.listarTodos();
                    for (Entrega e : entregas) {
                        System.out.println("ID: " + e.getId() +
                        		" | Cliente: " + e.getCliente().getId() +
                                " | Motorista: " + e.getMotorista().getId() +
                                " | Veículo: " + e.getVeiculo().getId() +
                                " | Carga: " + e.getCarga().getId() +
                                " | Status: " + e.getStatus() +
                                " | Saída: " + e.getDtSaida() +
                                " | Entrega: " + e.getDtEntrega());
                    }
                    break;
                case 3:
                    System.out.print("ID da Entrega a ser atualizada: ");
                    int id = scanner.nextInt();
                    Entrega entregaAtualizar = entregaDAO.buscarPorId(id);
                    
                    if (entregaAtualizar != null) {
                    	System.out.print("Novo ID do Cliente: ");
                        Cliente novoCliente = new Cliente();
                        novoCliente.setId(scanner.nextInt());
                        entregaAtualizar.setCliente(novoCliente);

                        System.out.print("Novo ID do Motorista: ");
                        Motorista novoMotorista = new Motorista();
                        novoMotorista.setId(scanner.nextInt());
                        entregaAtualizar.setMotorista(novoMotorista);

                        System.out.print("Novo ID do Veículo: ");
                        Veiculo novoVeiculo = new Veiculo();
                        novoVeiculo.setId(scanner.nextInt());
                        entregaAtualizar.setVeiculo(novoVeiculo);

                        System.out.print("Novo ID da Carga: ");
                        Carga novaCarga = new Carga();
                        novaCarga.setId(scanner.nextInt());
                        entregaAtualizar.setCarga(novaCarga);

                        scanner.nextLine(); 
                        System.out.print("Novo Status: ");
                        entregaAtualizar.setStatus(scanner.nextLine());

                        System.out.print("Nova Data de Saída (YYYY-MM-DD): ");
                        entregaAtualizar.setDtSaida(Date.valueOf(scanner.next()));

                        System.out.print("Nova Data da Entrega (YYYY-MM-DD): ");
                        entregaAtualizar.setDtEntrega(Date.valueOf(scanner.next()));

                        entregaDAO.atualizar(entregaAtualizar);
                        System.out.println("Entrega atualizada com sucesso!");
                    } else {
                        System.out.println("Entrega não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("ID da Entrega a ser excluída: ");
                    int idExcluir = scanner.nextInt();
                    entregaDAO.excluir(idExcluir);
                    System.out.println("Entrega excluida com sucesso!");
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}