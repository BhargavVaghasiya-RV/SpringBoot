# Are you frustrated of writing the same code over and over again? This is the solution.

The number of models and controllers for building API endpoints is growing over time. Each controller has a number of endpoints that carry out CRUD operations. The code is almost the same in all controllers and services.

Consider creating common classes that can offer CRUD APIs for any model you have. You'll save a significant amount of time.

Let me give you a code overview here

The standard approach can be utilized for creating the model and repository.

### Base Controller

```java
public abstract class BaseController<T,R> {
	
	@PostMapping("/save")
	public <S extends T> S save(@RequestBody Object record) {
		ModelService<T, R> myService = applicationContext.getBean(getDTOClass().getName(), ModelService.class);
		return myService.save((S) mapper.map(record, getDTOClass()));
	}
	
	...

	@Autowired
	public BaseController(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public abstract Class<?> getDTOClass();

	private final ApplicationContext applicationContext;

	private final ModelMapper mapper = new ModelMapper();
}
```

### Common Model Service

```java
public interface ModelService<T, R> {

	public <S extends T> S save(S record);

	public T get(R id);

	public List<T> getall();

	public <S extends T> void delete(S record);
}
```
### Common Base Model Service
```java
public abstract class BaseModelService<T, R> implements ModelService<T, R> {

	public abstract JpaRepository<T, R> getBaseService();

	@Override
	public <S extends T> S save(S record) {
		return getBaseService().save(record);
	}

	@Override
	public T get(R id) {
		Optional<T> record = getBaseService().findById(id);
		if (record.isPresent()) {
			return record.get();
		}
		return record.orElseThrow();
	}

	@Override
	public List<T> getall() {
		return getBaseService().findAll();
	}

	@Override
	public <S extends T> void delete(S record) {
		getBaseService().delete(record);
	}
}
```

All of your models can have CRUD APIs provided by these classes. 

Let me now explain how to use them.

### Extend your controller with BaseController

```java
@RestController
@RequestMapping("users/")
public class UserController extends BaseController<User, Long> {
	
	  @Autowired
	UserService userService;

	public UserController(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	public Class<?> getDTOClass() {
		return User.class;
	}
}
```

### Extend your service class with BaseModelService

```java
@Service("com.brgv.dynamic_crud.model.User")
public class UserServiceImpl extends BaseModelService<User, Long> implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public JpaRepository<User, Long> getBaseService() {
		return userRepository;
	}
}
```

That's it.

Clone this repo for a clear understanding

## About Author

Name : Bhargav Vaghasiya (Liferay Practice Head | Liferay Architect | Java Expert)

Email Address : brgv1106@gmail.com

Phone Number : +91 7405401822

GitHub Account : https://github.com/BhargavVaghasiya-RV

LinkedIn : www.linkedin.com/in/bhargavvaghasiya
