����һ���������ӵĳ��򣬿��Բ����û���Oracle�����ǲ��������������ӳɹ���
���������ݿ�ķ�ʽ�����ǵĲ�Ʒ�еķ�ʽ��һģһ���ġ�
�����������ӳɹ����ǲ�Ʒ��ҲӦ��û�����⡣������֤�����ǿͻ����ݿ����ӵ����⡣
�������������ӳɹ�����ô���ȼ���ǲ��ǿͻ����ݿ����ӵ����⣬�ټ���ǲ�������ʹ�õ��������İ汾���⣬���ż���Ʒ�еĴ���

�����Ʒ�����������
1. һ����Ϊconnchecker-1.0-SNAPSHOT.jar��java����ִ�а�
2. һ����Ϊlib���ļ��У���߰����������ݿ������
3. һ��readme.txt�ļ������ļ���д����������ߵ��÷�

�����÷���
1. ��zip����ѹ�����ǲ�Ʒ�������ϵ�����һ��·���£���֤lib��connchecker-1.0-SNAPSHOT.jar��ͬһ·����
2. �޸�connchecker-1.0-SNAPSHOT.jar�е�c3p0-config.xml�ļ������ͻ���Oracle���ݿ����Ϣ���µ��������ļ��ϡ�
������ô��Linux�����¸���jar���е������ļ�����ٶ�һ�����н�����޸ķ�Χ���£�

<named-config name="customerOracle">
        <property name="user">MONI3</property>
        <property name="password">MONI3</property>
        <property name="jdbcUrl">jdbc:oracle:thin:@192.168.1.231:1521/orcl</property>
        <property name="driverClass">oracle.jdbc.OracleDriver</property>
        <!-- ��������������Ӳ���ʱһ���������ٸ� -->
        <property name="acquireIncrement">5</property>
        <!-- ��ʼ�����ݿ����ӳ�ʱ���ӵ����� -->
        <property name="initialPoolSize">20</property>
        <!-- ���ݿ����ӳ��е��������ݿ������� -->
        <property name="maxPoolSize">25</property>
        <!-- ���ݿ����ӳ��е���С�����ݿ������� -->
        <property name="minPoolSize">5</property>
    </named-config>

3. �ڸ�·����ʹ��java -jar connchecker-1.0-SNAPSHOT.jar������ִ��
�������������־�����ʾ�����������û�Oracle���ݿ�
��Ϣ: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 30000, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hge16ma117wqza612rs4av|1c23cae6, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.jdbc.Driver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hge16ma117wqza612rs4av|1c23cae6, idleConnectionTestPeriod -> 30, initialPoolSize -> 10, jdbcUrl -> jdbc:mysql://127.0.0.1:9207/dbmask, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 30, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 100, maxStatements -> 200, maxStatementsPerConnection -> 0, minPoolSize -> 10, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {test-user={maxStatements=0, maxPoolSize=10, minPoolSize=1}}, usesTraditionalReflectiveProxies -> false ]
create mysql connection successfully.
���� 21, 2019 11:17:26 ���� com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
��Ϣ: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 5, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 30000, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> customerOracle, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> oracle.jdbc.OracleDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hge16ma117wqza612rs4av|216c6a89, idleConnectionTestPeriod -> 30, initialPoolSize -> 20, jdbcUrl -> jdbc:oracle:thin:@192.168.1.231:1521/orcl, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 30, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 25, maxStatements -> 200, maxStatementsPerConnection -> 0, minPoolSize -> 5, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {test-user={maxStatements=0, maxPoolSize=10, minPoolSize=1}}, usesTraditionalReflectiveProxies -> false ]
create oracle connection successfully.

4. �������������Ϣ������Է������з����з�������������ƾ�����滻Oracle�������������Խ����