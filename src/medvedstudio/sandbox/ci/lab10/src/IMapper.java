package medvedstudio.sandbox.ci.lab10.src;

public interface IMapper<TDestination, TSource> {

    TDestination map(TSource source, Class<TDestination> destionationType) throws Exception;
}
