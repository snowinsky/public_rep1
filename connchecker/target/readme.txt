这是一个测试连接的程序，可以测试用户的Oracle数据是不是能正常的连接成功。
该连接数据库的方式和我们的产品中的方式是一模一样的。
如果这个能连接成功，那产品中也应该没有问题。起码能证明不是客户数据库连接的问题。
如果这个不能连接成功，那么就先检查是不是客户数据库连接的问题，再检查是不是咱们使用的驱动包的版本问题，最后才检查产品中的代码

这个产品包含如下三项：
1. 一个名为connchecker-1.0-SNAPSHOT.jar的java程序执行包
2. 一个名为lib的文件夹，里边包含连接数据库的驱动
3. 一个readme.txt文件，该文件中写明了这个工具的用法

具体用法：
1. 将zip包解压在咱们产品服务器上的任意一个路径下，保证lib和connchecker-1.0-SNAPSHOT.jar在同一路径下
2. 修改connchecker-1.0-SNAPSHOT.jar中的c3p0-config.xml文件，将客户的Oracle数据库的信息更新到该配置文件上。
具体怎么在Linux环境下更新jar包中的配置文件，请百度一下自行解决。修改范围如下：

<named-config name="customerOracle">
        <property name="user">MONI3</property>
        <property name="password">MONI3</property>
        <property name="jdbcUrl">jdbc:oracle:thin:@192.168.1.231:1521/orcl</property>
        <property name="driverClass">oracle.jdbc.OracleDriver</property>
        <!-- 如果池中数据连接不够时一次增长多少个 -->
        <property name="acquireIncrement">5</property>
        <!-- 初始化数据库连接池时连接的数量 -->
        <property name="initialPoolSize">20</property>
        <!-- 数据库连接池中的最大的数据库连接数 -->
        <property name="maxPoolSize">25</property>
        <!-- 数据库连接池中的最小的数据库连接数 -->
        <property name="minPoolSize">5</property>
    </named-config>

3. 在该路径下使用java -jar connchecker-1.0-SNAPSHOT.jar命令来执行
如果出现如下日志，则表示能正常连接用户Oracle数据库
信息: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 30000, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hge16ma117wqza612rs4av|1c23cae6, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.jdbc.Driver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hge16ma117wqza612rs4av|1c23cae6, idleConnectionTestPeriod -> 30, initialPoolSize -> 10, jdbcUrl -> jdbc:mysql://127.0.0.1:9207/dbmask, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 30, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 100, maxStatements -> 200, maxStatementsPerConnection -> 0, minPoolSize -> 10, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {test-user={maxStatements=0, maxPoolSize=10, minPoolSize=1}}, usesTraditionalReflectiveProxies -> false ]
create mysql connection successfully.
三月 21, 2019 11:17:26 上午 com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
信息: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 5, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 30000, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> customerOracle, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> oracle.jdbc.OracleDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hge16ma117wqza612rs4av|216c6a89, idleConnectionTestPeriod -> 30, initialPoolSize -> 20, jdbcUrl -> jdbc:oracle:thin:@192.168.1.231:1521/orcl, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 30, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 25, maxStatements -> 200, maxStatementsPerConnection -> 0, minPoolSize -> 5, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {test-user={maxStatements=0, maxPoolSize=10, minPoolSize=1}}, usesTraditionalReflectiveProxies -> false ]
create oracle connection successfully.

4. 如果包含报错信息，则可以反馈给研发进行分析，或者自行凭经验替换Oracle的驱动包来尝试解决。