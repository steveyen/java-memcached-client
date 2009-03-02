package net.spy.memcached;

import junit.framework.TestCase;
import net.spy.memcached.protocol.ascii.AsciiOperationFactory;
import net.spy.memcached.transcoders.SerializingTranscoder;

/**
 * Test the connection factory builder.
 */
public class ConnectionFactoryBuilderTest extends TestCase {

	private ConnectionFactoryBuilder b;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		b = new ConnectionFactoryBuilder();
	}

	public void testDefaults() {
		ConnectionFactory f = b.build();
		assertEquals(DefaultConnectionFactory.DEFAULT_OPERATION_TIMEOUT,
				f.getOperationTimeout());
		assertEquals(DefaultConnectionFactory.DEFAULT_READ_BUFFER_SIZE,
				f.getReadBufSize());
		assertSame(DefaultConnectionFactory.DEFAULT_HASH, f.getHashAlg());
		assertTrue(f.getDefaultTranscoder() instanceof SerializingTranscoder);
		assertSame(DefaultConnectionFactory.DEFAULT_FAILURE_MODE,
				f.getFailureMode());
		assertEquals(0, f.getInitialObservers().size());
		assertTrue(f.getOperationFactory() instanceof AsciiOperationFactory);
	}

}
