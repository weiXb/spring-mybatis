package cn.wxb.dynamic;

public class DynamicDataSourceHolder {
    private DynamicDataSourceHolder() {
    }

    private static final ThreadLocal<SourcesEnum> datasourceThreadLocal = new ThreadLocal<>();

    public static void setDatasource(SourcesEnum datasource) {
        datasourceThreadLocal.set(datasource);
    }

    public static SourcesEnum getDatasource() {
        return datasourceThreadLocal.get();
    }
}
