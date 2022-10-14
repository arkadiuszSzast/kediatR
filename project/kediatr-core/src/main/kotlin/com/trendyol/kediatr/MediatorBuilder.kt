package com.trendyol.kediatr

class MediatorBuilder(
    private val dependencyProvider: DependencyProvider,
) {
    internal var publishStrategy: PublishStrategy = StopOnExceptionPublishStrategy()
        private set

    /**
     * Overrides default notification publishing strategy.
     * Default strategy is [StopOnExceptionPublishStrategy]
     *
     * @since 1.0.9
     * @see [PublishStrategy]
     * @see [ContinueOnExceptionPublishStrategy]
     * @see [StopOnExceptionPublishStrategy]
     * @see [ParallelNoWaitPublishStrategy]
     * @see [ParallelWhenAllPublishStrategy]
     */
    fun withPublishStrategy(publishStrategy: PublishStrategy): MediatorBuilder {
        this.publishStrategy = publishStrategy
        return this
    }

    fun build(registry: Registry = RegistryImpl(dependencyProvider)): Mediator {
        return MediatorImpl(registry, publishStrategy)
    }
}