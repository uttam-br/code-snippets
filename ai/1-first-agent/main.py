import asyncio
from picoagents import Agent, OpenAIChatCompletionClient

def get_weather(location: str) -> str: 
    """Get current weather for a given location"""
    return f"The answer in {location} is sunny, 75 degrees F"

async def main():
    
    agent = Agent(
        name="Assistant",
        description="You are a helpful assistant",
        instructions="You are helpful. Use tools when appropriate",
        model_client=OpenAIChatCompletionClient(
            base_url="http://localhost:11434",
            api_key="ollama",
            model="gemma3:270m"
        )
    )

    async for event in agent.run_stream("What's the weather in Paris ?"):
        print(event)

if __name__ == "__main__":
    asyncio.run(main())

