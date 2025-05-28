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
import util.VerQuantidade;

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
			System.out.print("\nEscolha uma opção: ");
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
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.print("\nEscolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				Cliente cliente = new Cliente();
				scanner.nextLine();
				System.out.print("Nome: ");
				cliente.setNome(scanner.nextLine());
				System.out.print("Endereço: ");
				cliente.setEndereco(scanner.nextLine());
				System.out.print("Telefone: ");
				cliente.setTelefone(scanner.nextLine());
				System.out.print("CPF: ");
				cliente.setCpf(scanner.next());
				clienteDAO.inserir(cliente);
				break;
			case 2:
				if (VerQuantidade.contarRegistros("cliente") == 0) {
					System.out.println("\nNão existem clientes cadastrados!\nVoltando...");
				} else {
					System.out.println("\nLista de Clientes:");
					List<Cliente> clientes = clienteDAO.listarTodos();
					for (Cliente c : clientes) {
						System.out.println(
								"-------------------------------" + "\n| ID: " + c.getId() + "\n| Nome: " + c.getNome()
										+ "\n| Telefone: " + c.getTelefone() + "\n| Endereço: " + c.getEndereco());
					}
					System.out.println("-------------------------------");
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("cliente") == 0) {
					System.out.println("\nNão existem clientes cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Cliente a ser atualizado: ");
					int id = scanner.nextInt();
					Cliente clienteAtualizar = clienteDAO.buscarPorId(id);
					if (clienteAtualizar != null) {
						System.out.print("Nome: " + clienteAtualizar.getNome());
						System.out.print("\nCPF: " + clienteAtualizar.getCpf());
						System.out.print("\nNovo Endereço: ");
						clienteAtualizar.setEndereco(scanner.next());
						System.out.print("Novo Telefone: ");
						clienteAtualizar.setTelefone(scanner.next());
						clienteDAO.atualizar(clienteAtualizar);
					} else {
						System.out.println("\nCliente não encontrado.");
					}
				}
				break;
			case 4:
				if (VerQuantidade.contarRegistros("cliente") == 0) {
					System.out.println("\nNão existem clientes cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Cliente a ser excluído: ");
					int idExcluir = scanner.nextInt();
					clienteDAO.excluir(idExcluir);
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.print("\nEscolha uma opção: ");
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
				if (VerQuantidade.contarRegistros("funcionario") == 0) {
					System.out.println("\nNão existem funcionarios cadastrados!\nVoltando...");
				} else {
					System.out.println("\nLista de Funcionários:");
					List<Funcionario> funcionarios = funcionarioDAO.listarTodos();
					for (Funcionario f : funcionarios) {
						System.out.println("-------------------------------" + "\n| ID: " + f.getId() + "\n| Nome: "
								+ f.getNome() + "\n| Cargo: " + f.getCargo());
					}
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("funcionario") == 0) {
					System.out.println("\nNão existem funcionarios cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Funcionário a ser atualizado: ");
					int id = scanner.nextInt();
					Funcionario funcionarioAtualizar = funcionarioDAO.buscarPorId(id);
					if (funcionarioAtualizar != null) {
						System.out.print("Nome: " + funcionarioAtualizar.getNome());
						System.out.print("\nNovo Endereço: ");
						funcionarioAtualizar.setEndereco(scanner.next());
						System.out.print("Novo Telefone: ");
						funcionarioAtualizar.setTelefone(scanner.next());
						System.out.print("Novo Cargo: ");
						funcionarioAtualizar.setCargo(scanner.next());
						System.out.print("Novo Salário: ");
						funcionarioAtualizar.setSalario(scanner.nextDouble());
						funcionarioDAO.atualizar(funcionarioAtualizar);
					} else {
						System.out.println("\nFuncionário não encontrado.");
					}
				}
				break;
			case 4:
				if (VerQuantidade.contarRegistros("funcionario") == 0) {
					System.out.println("\nNão existem funcionarios cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Funcionário a ser excluído: ");
					int idExcluir = scanner.nextInt();
					funcionarioDAO.excluir(idExcluir);
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.print("\nEscolha uma opção: ");
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
				motorista.setCargo("Motorista");
				System.out.print("Salário: ");
				motorista.setSalario(scanner.nextDouble());
				System.out.print("CNH: ");
				motorista.setCnh(scanner.next());
				System.out.print("Rota: ");
				motorista.setRota(scanner.next());
				motoristaDAO.inserir(motorista);
				break;
			case 2:
				if (VerQuantidade.contarRegistros("motorista") == 0) {
					System.out.println("\nNão existem motoristas cadastrados!\nVoltando...");
				} else {
					System.out.println("\nLista de Motoristas:");
					List<Motorista> motoristas = motoristaDAO.listarTodos();
					for (Motorista m : motoristas) {
						System.out.println(m.getId() + " - " + m.getNome());
					}
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("motorista") == 0) {
					System.out.println("\nNão existem motoristas cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Motorista a ser atualizado: ");
					int id = scanner.nextInt();
					Motorista motoristaAtualizar = motoristaDAO.buscarPorId(id);
					if (motoristaAtualizar != null) {
						System.out.print("Nome: " + motoristaAtualizar.getNome());
						System.out.print("\nNovo Endereço: ");
						motoristaAtualizar.setEndereco(scanner.next());
						System.out.print("Novo Telefone: ");
						motoristaAtualizar.setTelefone(scanner.next());
						motoristaAtualizar.setCargo("Motorista");
						System.out.print("Novo Salário: ");
						motoristaAtualizar.setSalario(scanner.nextDouble());
						System.out.print("Nova CNH: ");
						motoristaAtualizar.setCnh(scanner.next());
						System.out.print("Nova Rota: ");
						motoristaAtualizar.setRota(scanner.next());
						motoristaDAO.atualizar(motoristaAtualizar);
					} else {
						System.out.println("\nMotorista não encontrado.");
					}
				}
				break;
			case 4:
				if (VerQuantidade.contarRegistros("motorista") == 0) {
					System.out.println("\nNão existem motoristas cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Motorista a ser excluído: ");
					int idExcluir = scanner.nextInt();
					motoristaDAO.excluir(idExcluir);
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.println("3. Excluir Veículo");
			System.out.println("0. Voltar");
			System.out.print("\nEscolha uma opção: ");
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
				if (VerQuantidade.contarRegistros("veiculo") == 0) {
					System.out.println("\nNão existem veiculos cadastrados!\nVoltando...");
				} else {
					System.out.println("\nLista de Veículos:");
					List<Veiculo> veiculos = veiculoDAO.listarTodos();
					for (Veiculo v : veiculos) {
						System.out.println(v.getId() + " - " + v.getModelo() + "-" + v.getPlaca());
					}
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("veiculo") == 0) {
					System.out.println("\nNão existem veiculos cadastrados!\nVoltando...");
				} else {
					System.out.print("\nID do Veículo a ser excluído: ");
					int idExcluir = scanner.nextInt();
					veiculoDAO.excluir(idExcluir);
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.print("\nEscolha uma opção: ");
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
				if (VerQuantidade.contarRegistros("carga") == 0) {
					System.out.println("\nNão existem cargas cadastradas!\nVoltando...");
				} else {
					System.out.println("\nLista de Cargas:");

					List<Carga> cargas = cargaDAO.listarTodos();
					for (Carga c : cargas) {
						System.out
								.println("------------------------\nID: " + c.getId() + "\nCarga: " + c.getDescricao());
					}
					System.out.println("------------------------");
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("carga") == 0) {
					System.out.println("\nNão existem cargas cadastradas!\nVoltando...");
				} else {
					System.out.print("ID da Carga a ser atualizada: ");
					int id = scanner.nextInt();
					Carga cargaAtualizar = cargaDAO.buscarPorId(id);
					if (cargaAtualizar != null) {
						if (!(cargaAtualizar.isEmRota())) {
							System.out.print("Nova Descrição: ");
							scanner.nextLine();
							cargaAtualizar.setDescricao(scanner.nextLine());
							System.out.print("Novo Peso (Kg): ");
							cargaAtualizar.setPeso(scanner.nextDouble());
							System.out.print("Novo Volume (m³): ");
							cargaAtualizar.setVolume(scanner.nextDouble());
							cargaAtualizar.setEmRota(false);
							cargaDAO.atualizar(cargaAtualizar);
							System.out.println("Carga Atualizada!");
						} else {
							System.out.println("Carga em rota!\nImpossivel Atualizar");
						}
					} else {
						System.out.println("\nCarga não encontrada.");
					}
				}
				break;
			case 4:
				if (VerQuantidade.contarRegistros("carga") == 0) {
					System.out.println("\nNão existem cargas cadastradas!\nVoltando...");
				} else {
					System.out.print("\nID da Carga a ser excluída: ");
					int idExcluir = scanner.nextInt();
					cargaDAO.excluir(idExcluir);
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
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
			System.out.print("\nEscolha uma opção: ");
			opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				Entrega entrega = new Entrega();

				System.out.println("ID do Cliente");
				entrega.setId_cliente(scanner.nextInt());

				System.out.println("ID do Motorista");
				int id_motorista = scanner.nextInt();
				entrega.setId_motorista(id_motorista);
				
				MotoristaDAO mD = new MotoristaDAO();
				Motorista motorista = mD.buscarPorId(id_motorista);
				motorista.setDisponivel(false);
				mD.atualizar(motorista);
				
				System.out.println("ID do Veículo: ");
				entrega.setId_veiculo(scanner.nextInt());

				System.out.println("ID da Carga: ");
				int id_carga = scanner.nextInt();
				entrega.setId_carga(id_carga);

				CargaDAO caDao = new CargaDAO();
				Carga carga = caDao.buscarPorId(id_carga);
				carga.setEmRota(true);
				caDao.atualizar(carga);

				scanner.nextLine();
				System.out.println("Status da Entrega: ");
				entrega.setStatus(scanner.nextLine());

				System.out.println("Previsão de entrega(AAAA-MM-DD): ");
				entrega.setDtEntrega(Date.valueOf(scanner.next()));

				entregaDAO.inserir(entrega);
				System.out.println("Entrega adicionada com sucesso!");
				break;
			case 2:
				if (VerQuantidade.contarRegistros("entrega") == 0) {
					System.out.println("\nNão existem entregas cadastradas!\nVoltando...");
				} else {
					System.out.println("\nLista de Entregas:");
					List<Entrega> entregas = entregaDAO.listarTodos();
					for (Entrega e : entregas) {
						System.out.println(
								"------------- ## -------------" + "\n|Id: " + e.getId() + "\n|Status" + e.getStatus());
						ClienteDAO clienteDAO = new ClienteDAO();
						System.out.println("|Proprietário: " + clienteDAO.buscarPorId(e.getId_cliente()).getNome());

						MotoristaDAO motoristaDAO = new MotoristaDAO();
						System.out.println("|Motorista: " + motoristaDAO.buscarPorId(e.getId_motorista()).getNome());

						VeiculoDAO veiculoDAO = new VeiculoDAO();
						System.out.println("|Veiculo: " + veiculoDAO.buscarPorId(e.getId_veiculo()).getModelo() + " - "
								+ veiculoDAO.buscarPorId(e.getId_veiculo()).getPlaca());

						CargaDAO cargaDAO = new CargaDAO();
						System.out.println("|Carga: " + cargaDAO.buscarPorId(e.getId_carga()).getDescricao());

						System.out.println("|Endereço de Entrega: " + clienteDAO.buscarPorId(e.getId_cliente()).getEndereco());

						System.out.println("|Previsão de entrega: " + e.getDtEntrega());
					}
					System.out.println("------------- ## -------------");
				}
				break;
			case 3:
				if (VerQuantidade.contarRegistros("entrega") == 0) {
					System.out.println("\nNão existem entregas cadastradas!\nVoltando...");
				} else {
					System.out.print("\nID da Entrega a ser atualizada: ");
					int id = scanner.nextInt();
					Entrega entregaAtualizar = entregaDAO.buscarPorId(id);

					if (entregaAtualizar != null) {
						System.out.print("ID do novo Motorista: ");
						entregaAtualizar.setId_motorista(scanner.nextInt());

						System.out.print("ID do novo Veículo: ");
						entregaAtualizar.setId_veiculo(scanner.nextInt());

						System.out.print("ID da nova Carga: ");
						entregaAtualizar.setId_carga(scanner.nextInt());

						scanner.nextLine();
						System.out.print("Novo Status: ");
						entregaAtualizar.setStatus(scanner.nextLine());

						System.out.print("Nova Data da Entrega (YYYY-MM-DD): ");
						entregaAtualizar.setDtEntrega(Date.valueOf(scanner.next()));

						entregaDAO.atualizar(entregaAtualizar);
						System.out.println("Entrega atualizada com sucesso!");
					} else {
						System.out.println("Entrega não encontrada.");
					}
				}
				break;
			case 4:
				if (VerQuantidade.contarRegistros("entrega") == 0) {
					System.out.println("\nNão existem entregas cadastradas!\nVoltando...");
				} else {
					System.out.print("\nID da Entrega a ser excluída: ");
					int idExcluir = scanner.nextInt();
					Entrega e = entregaDAO.buscarPorId(idExcluir);
					
					CargaDAO cDao = new CargaDAO();
					Carga c = cDao.buscarPorId(e.getId_carga());
					c.setEmRota(false);
					
					MotoristaDAO mDao = new MotoristaDAO();
					Motorista m = mDao.buscarPorId(e.getId_motorista());
					
					//Excluir e alterar
					entregaDAO.excluir(idExcluir);

					m.setDisponivel(true);
					System.out.println("\nEntrega excluida com sucesso!");
				}
				break;
			case 0:
				System.out.println("\nVoltando...");
				break;
			default:
				System.out.println("\nOpção inválida! Tente novamente.");
			}
		} while (opcao != 0);
	}
}