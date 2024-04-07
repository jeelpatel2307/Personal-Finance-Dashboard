@SpringBootApplication
public class FinanceDashboard {
    public static void main(String[] args) {
        SpringApplication.run(FinanceDashboard.class, args);
    }

    @RestController
    @RequestMapping("/dashboard")
    public class DashboardController {
        private final TransactionService transactionService;
        private final BudgetService budgetService;

        public DashboardController(TransactionService transactionService, BudgetService budgetService) {
            this.transactionService = transactionService;
            this.budgetService = budgetService;
        }

        @GetMapping
        public DashboardResponse getDashboard() {
            List<Transaction> transactions = transactionService.getAllTransactions();
            Budget budget = budgetService.getBudget();
            return new DashboardResponse(transactions, budget);
        }
    }

    @Service
    public class TransactionService {
        private final TransactionRepository transactionRepository;

        public TransactionService(TransactionRepository transactionRepository) {
            this.transactionRepository = transactionRepository;
        }

        public List<Transaction> getAllTransactions() {
            return transactionRepository.findAll();
        }

        public void createTransaction(Transaction transaction) {
            transactionRepository.save(transaction);
        }
    }

    @Service
    public class BudgetService {
        private final BudgetRepository budgetRepository;

        public BudgetService(BudgetRepository budgetRepository) {
            this.budgetRepository = budgetRepository;
        }

        public Budget getBudget() {
            return budgetRepository.findById(1L).orElse(new Budget());
        }

        public void updateBudget(Budget budget) {
            budgetRepository.save(budget);
        }
    }

    @Entity
    @Data
    public class Transaction {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String description;
        private double amount;
        private LocalDate date;
    }

    @Entity
    @Data
    public class Budget {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double income;
        private double expenses;
    }

    @Data
    @AllArgsConstructor
    public class DashboardResponse {
        private List<Transaction> transactions;
        private Budget budget;
    }

    public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    }

    public interface BudgetRepository extends JpaRepository<Budget, Long> {
    }
}
