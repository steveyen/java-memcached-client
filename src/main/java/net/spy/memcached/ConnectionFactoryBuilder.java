package net.spy.memcached;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;

import net.spy.memcached.ops.Operation;
import net.spy.memcached.transcoders.Transcoder;

/**
 * Builder for more easily configuring a ConnectionFactory.
 */
public class ConnectionFactoryBuilder {

	private BlockingQueue<Operation> opQueue;
	private BlockingQueue<Operation> readOpQueue;
	private BlockingQueue<Operation> writeOpQueue;

	private Transcoder<Object> transcoder;

	private FailureMode failureMode;

	private Collection<ConnectionObserver> initialObservers;

	private OperationFactory opFact;

	private long opTimeout = -1;
	private boolean isDaemon = true;

	private int readBufSize = -1;
	private HashAlgorithm hashAlg;

	public ConnectionFactoryBuilder setOpQueue(BlockingQueue<Operation> q) {
		opQueue = q;
		return this;
	}

	public ConnectionFactoryBuilder setReadOpQueue(BlockingQueue<Operation> q) {
		readOpQueue = q;
		return this;
	}

	public ConnectionFactoryBuilder setWriteOpQueue(BlockingQueue<Operation> q) {
		writeOpQueue = q;
		return this;
	}

	public ConnectionFactoryBuilder setTranscoder(Transcoder<Object> t) {
		transcoder = t;
		return this;
	}

	public ConnectionFactoryBuilder setFailureMode(FailureMode fm) {
		failureMode = fm;
		return this;
	}

	public ConnectionFactoryBuilder setInitialObservers(
			Collection<ConnectionObserver> obs) {
		initialObservers = obs;
		return this;
	}

	public ConnectionFactoryBuilder setOpFact(OperationFactory f) {
		opFact = f;
		return this;
	}

	public ConnectionFactoryBuilder setOpTimeout(long t) {
		opTimeout = t;
		return this;
	}

	public ConnectionFactoryBuilder setDaemon(boolean d) {
		isDaemon = d;
		return this;
	}

	public ConnectionFactoryBuilder setReadBufferSize(int to) {
		readBufSize = to;
		return this;
	}

	public ConnectionFactoryBuilder setHashAlg(HashAlgorithm to) {
		hashAlg = to;
		return this;
	}

	/**
	 * Get the ConnectionFactory set up with the proivided parameters.
	 */
	public ConnectionFactory build() {
		return new DefaultConnectionFactory() {

			// TODO:  Test createOperationQueue default
			// TODO:  Test createOperationQueue modified
			@Override
			public BlockingQueue<Operation> createOperationQueue() {
				return opQueue == null ?
						super.createOperationQueue() : opQueue;
			}

			// TODO:  Test createReadOperationQueue default
			// TODO:  Test createReadOperationQueue modified
			@Override
			public BlockingQueue<Operation> createReadOperationQueue() {
				return readOpQueue == null ?
						super.createReadOperationQueue() : readOpQueue;
			}

			// TODO:  Test createWriteOperationQueue default
			// TODO:  Test createWriteOperationQueue modified
			@Override
			public BlockingQueue<Operation> createWriteOperationQueue() {
				return writeOpQueue == null ?
						super.createWriteOperationQueue() : writeOpQueue;
			}

			// TODO:  Test getDefaultTranscoder modified
			@Override
			public Transcoder<Object> getDefaultTranscoder() {
				return transcoder == null ?
						super.getDefaultTranscoder() : transcoder;
			}

			// TODO:  Test getFailureMode modified
			@Override
			public FailureMode getFailureMode() {
				return failureMode == null ?
						super.getFailureMode() : failureMode;
			}

			// TODO:  Test getHashAlg modified
			@Override
			public HashAlgorithm getHashAlg() {
				return hashAlg == null ? super.getHashAlg() : hashAlg;
			}

			// TODO:  Test getInitialObservers modified
			@Override
			public Collection<ConnectionObserver> getInitialObservers() {
				return initialObservers;
			}

			// TODO:  Test getOperationFactory modified
			@Override
			public OperationFactory getOperationFactory() {
				return opFact == null ? super.getOperationFactory() : opFact;
			}

			// TODO:  Test getOperationTimeout modified
			@Override
			public long getOperationTimeout() {
				return opTimeout == -1 ?
						super.getOperationTimeout() : opTimeout;
			}

			// TODO:  Test getReadBufSize modified
			@Override
			public int getReadBufSize() {
				return readBufSize == -1 ?
						super.getReadBufSize() : readBufSize;
			}

			// TODO:  Test isDaemon default
			// TODO:  Test isDaemon modified
			@Override
			public boolean isDaemon() {
				return isDaemon;
			}

		};

	}

}
